package ru.itmo.genpythonclass

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class CreateClassAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val dialog = ClassConstructorDialogWindow(e.project)
        dialog.title = "Create Python File"

        dialog.show()

        dialog.save()
    }
}