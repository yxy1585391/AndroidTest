package com.example.cameraalbumtest

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.content.FileProvider
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    private val takePhoto = 1
    lateinit var imageUri: Uri
    lateinit var outputImage: File

    private var fromAlbum = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        takePhotoBtn.setOnClickListener {
            //创建File对象 用于存储拍照后的图片
            outputImage = File(externalCacheDir,"output_image.jpg")
            if (outputImage.exists()) {
                outputImage.delete()
            }
            outputImage.createNewFile()
            imageUri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                FileProvider.getUriForFile(this,"com.example.cameraalbumtest.fileprovider",outputImage)
            }else{
                Uri.fromFile(outputImage)
            }
            //启动相机程序
            val intent = Intent("android.media.action.IMAGE_CAPTURE")
            intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri)
            startActivityForResult(intent,takePhoto)
        }

        fromAlbumBtn.setOnClickListener {
            //打开文件选择器
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            //指定只显示图片
            intent.type = "image/*"
            startActivityForResult(intent,fromAlbum)
        }
    }

    /*
    如果使用startActivityForResult 那么就会有返回结果 在onActivityResult方法中做相应的处理
    */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            takePhoto -> {
                if (resultCode == Activity.RESULT_OK) {
                    //将拍摄的照片显示出来
                    val bitmap = BitmapFactory.decodeStream(contentResolver.openInputStream(imageUri))
                    imageView.setImageBitmap(rotateIfRequired(bitmap))
                }
            }
            fromAlbum -> {
                if (requestCode == Activity.RESULT_OK && data != null) {
                    data.data?.let { uri ->
                        //将选择的图片显示
                        val bitmap = getBitmapFromUri(uri)
                        imageView.setImageBitmap(bitmap)
                    }
                }
            }

        }
    }

    private fun getBitmapFromUri(uri: Uri) = contentResolver
            .openFileDescriptor(uri, "r")?.use {
                BitmapFactory.decodeFileDescriptor(it.fileDescriptor)
            }

    private fun rotateIfRequired(bitmap: Bitmap): Bitmap {
        val exif = ExifInterface(outputImage.path)
        return when(exif.getAttributeInt(ExifInterface.TAG_ORIENTATION,ExifInterface.ORIENTATION_NORMAL)) {
            ExifInterface.ORIENTATION_ROTATE_90 ->  rotateBitmap(bitmap,90)
            ExifInterface.ORIENTATION_ROTATE_180 -> rotateBitmap(bitmap,180)
            ExifInterface.ORIENTATION_ROTATE_270 -> rotateBitmap(bitmap,270)
            else -> bitmap
        }
    }

    private fun rotateBitmap(bitmap: Bitmap, degree: Int): Bitmap {
        val matrix = Matrix()
        matrix.postRotate(degree.toFloat())
        val rotateBitmap = Bitmap.createBitmap(bitmap,0,0,bitmap.width,bitmap.height,matrix,true)
        bitmap.recycle() //将不再需要的bitmap对象释放
        return rotateBitmap

    }
}