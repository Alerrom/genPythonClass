package ru.itmo.genpythonclass

import com.intellij.notification.Notification
import com.intellij.notification.NotificationType
import com.intellij.notification.Notifications
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import javax.swing.JFileChooser

class CreateClassAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val dialog = ClassConstructorDialogWindow(e.project)
        dialog.title = "Create Python File"
        dialog.show()

        val fc = JFileChooser()
        fc.fileSelectionMode = JFileChooser.DIRECTORIES_ONLY

        val returnVal = fc.showOpenDialog(dialog.owner)

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            val file = fc.selectedFile.toString()
            dialog.save(file)
        } else {
            throw Exception("Directory has not chosen!")
        }
    }
}