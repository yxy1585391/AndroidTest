package com.example.networktest

import android.util.Log
import org.xml.sax.Attributes
import org.xml.sax.helpers.DefaultHandler
import java.lang.StringBuilder

class ContentHandler : DefaultHandler() {

    private var nodeName = ""
    private lateinit var id: StringBuilder
    private lateinit var name: StringBuilder
    private lateinit var version: StringBuilder

    override fun startDocument() {
        id = StringBuilder()
        name = StringBuilder()
        version = StringBuilder()
    }

    override fun startElement(
        uri: String?,
        localName: String?,
        qName: String?,
        attributes: Attributes?
    ) {
        //记录当前节点名
        if (localName != null) {
            nodeName = localName
        }
        Log.d("ContentHandler","uri is $uri")
        Log.d("ContentHandler","localName is $localName")
        Log.d("ContentHandler","qName is $qName")
        Log.d("ContentHandler","attributes is $attributes")
    }

//    在获取节点内容的时候 characters会被调用多次 一些换行符也被当做内容解析出来
    override fun characters(ch: CharArray?, start: Int, length: Int) {
        when(nodeName) {
            "id" -> id.append(ch,start,length)
            "name" -> name.append(ch,start,length)
            "version" -> version.append(ch,start,length)
        }
    }

    override fun endDocument() {

    }

    override fun endElement(uri: String?, localName: String?, qName: String?) {
        if ("app" == localName) {
            Log.d("ContentHandler","id is ${id.toString().trim()}")
            Log.d("ContentHandler","name is ${name.toString().trim()}")
            Log.d("ContentHandler","version is ${version.toString().trim()}")
            //最后将StringBuilder清空
            id.setLength(0)
            name.setLength(0)
            version.setLength(0)
        }
    }
}