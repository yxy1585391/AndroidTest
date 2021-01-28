package com.example.jetpacktest

import java.lang.StringBuilder

class Dependency {
    private val libraries = ArrayList<String>()

    fun implementation(lib: String) {
        libraries.add(lib)
    }

    fun dependencies(block: Dependency.() -> Unit): List<String> {
        val dependency = Dependency()
        dependency.block()
        return dependency.libraries
    }
}

class Td {
    var content = ""
    fun html() = "\n\t\t<td>$content</td>"
}

class Tr {
    private val children = ArrayList<Td>()

    fun tb(block: Td.() -> String) {
        val td = Td()
        td.content = td.block()
        children.add(td)
    }

    fun html(): String {
        val builder = StringBuilder()
        builder.append("\n\t<tr>")
        for (childTag in children) {
            builder.append(childTag.html())
        }
        builder.append("\n\t</tr>")
        return builder.toString()
    }
}