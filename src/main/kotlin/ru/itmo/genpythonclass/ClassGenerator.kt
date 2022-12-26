package ru.itmo.genpythonclass

class ClassGenerator(docString: String, isEnMethodSelected: Boolean, isRuMethodSelected: Boolean) {
    private var context: String = ""
    private var docString: String = ""
    private var isEnSelected: Boolean = false
    private var isRuSelecled: Boolean = false

    init {
        this.docString = docString
        isEnSelected = isEnMethodSelected
        isRuSelecled = isRuMethodSelected
    }

    fun getContext(): String {
        context += getImport()
        context += getPythonClass()
        context += getLatexQuestionWriter()
        context += getReportAndParserMethod()
        return context
    }

    private fun getImport(): String {
        return "from all_imports import *\n\n"
    }

    private fun getPythonClass(): String {
        return "class Problem(GenericProblem):\n" +
                "    \"" + "\"" + "\"\n" +
                docString + "\n" +
                "    \"" + "\"" + "\"\n\n" +
                "    @classmethod\n" +
                "    def generate(cls):\n" +
                "        return Problem()\n\n"
    }

    private fun getLatexQuestionWriter(): String {
        var res = "    def write_question_tex(self):\n" +
                "        content = \"\"\n" +
                "        return content\n\n"

        if (isEnSelected) {
            res += "    def write_question_tex_en(self):\n" +
                    "        content = \"\"\n" +
                    "        return content\n\n"
        }

        if (isRuSelecled) {
            res += "    def write_question_tex_ru(self):\n" +
                    "        content = \"\"\n" +
                    "        return content\n\n"
        }
        return res
    }

    private fun getReportAndParserMethod(): String {
        return "    def write_report_tex(self, attempt):\n" +
                "        pass\n\n" +
                "    def parse_attempt(self, attempt_string: str):\n" +
                "        pass\n\n" +
                "    def is_attempt_valid(self, attempt):\n" +
                "        pass\n"
    }
}