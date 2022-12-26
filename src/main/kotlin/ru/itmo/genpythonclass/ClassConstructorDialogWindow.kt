package ru.itmo.genpythonclass

import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogWrapper
import java.io.File
import javax.swing.*


class ClassConstructorDialogWindow(project: Project?) : DialogWrapper(project) {
    private var fileName: JTextField? = null
    private var contentPanel: JPanel? = null
    private var docString: JTextArea? = null
    private var addEnglishTexMethod: JRadioButton? = null
    private var addRussianTexMethod: JRadioButton? = null
    private var fileNameLabel: JLabel? = null
    private var taskDescLabel: JLabel? = null
    private var dirLabel: JLabel? = null

    init {
        init()
    }

    override fun createCenterPanel(): JComponent? {
        return contentPanel
    }

    fun save(dirName: String) {
        var path = dirName
        path += if (dirName[dirName.length - 1].equals("\\")) {
            fileName!!.text
        } else {
            "\\" + fileName!!.text
        }

        val file = File(path)
        val text = ClassGenerator(
            docString!!.text,
            addEnglishTexMethod!!.isSelected,
            addRussianTexMethod!!.isSelected
        ).getContext()

        file.writeText(text)
    }
}
