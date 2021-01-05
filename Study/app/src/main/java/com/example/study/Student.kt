package com.example.study
/*
* 想要继承类 是使用冒号
* */

/*
* 每个类都会有一个默认的不带参数的主构造函数
* 当然也可以显式的给他指明参数 主构造函数的特点就是没有函数体 直接定义在类名的后面即可
* */

/*
主构造函数由于没有函数体 所以 他的逻辑都写在init方法中
* */

/*
* 如果父类没有无参主构造函数 那么他的子类要把想调用的父类的主构造函数 就要在子类的构造函数里面把父类需要的
* 参数添加进来 然后传递给父类即可
* */

//class Student(val sno: String, val grade: Int, name: String, age: Int): Person(name,age) {
//    //次构造函数
//    constructor(name: String, age: Int): this("",0,name,age){
//
//    }
//    constructor():this("",0) {
//
//    }
//}

class Student(name: String, age: Int): Person(name,age),Study {
    override fun readBooks() {
        println("$name is reading")
    }

    override fun doHomework() {
        println("$name is doing homework")
    }
}


/*
当一个类既有主构造函数又有次构造函数的时候 所有的次构造函数都必须调用主构造函数(包括间接调用)
* */

/*
当一个类没有显式的定义主构造函数且定义了次构造函数的时候,他是没有主构造函数的
* */

//class Student: Person {
//    constructor(name: String, age: Int): super(name,age) {
//
//    }
//}

fun main() {
//    val student1 = Student()
    val student2 = Student("jack",19)
//    val student3 = Student("22",5,"jack",19)
    doStudy(student2)
}

/*
面向接口编程
也就说多态
* */
fun doStudy(study: Study) {
    study.readBooks()
    study.doHomework()
}

/*
* public        kotlin默认的修饰符 对所有类可见
* private       对当前类内部可见
* protected     在java中表示对当前类 子类和同一包路径下的类可见
*               在kotlin中标识只对当前类和子类可见
* internal      对同一模块内可见
* */