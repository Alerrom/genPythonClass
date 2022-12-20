package ru.itmo.genpythonclass

import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogWrapper
import java.io.File
import javax.swing.*

class ClassConstructorDialogWindow(private var project: Project?) : DialogWrapper(project) {
    private var dirPath: JTextField? = null
    private var contentPanel: JPanel? = null
    private var docString: JTextArea? = null
    private var addEnglishTexMethod: JRadioButton? = null
    private var addRussianTexMethod: JRadioButton? = null

    init {
        init()
    }

    override fun createCenterPanel(): JComponent? {
        return contentPanel
    }

    fun save() {
        val file = File(dirPath!!.text)
        val text = ClassGenerator(docString!!.text,
            addEnglishTexMethod!!.isSelected,
            addRussianTexMethod!!.isSelected).getContext()

        file.writeText(text)
    }
}