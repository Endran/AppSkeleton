package nl.endran.skeleton.kotlin.example

class ModelInteractor(val name: String) {
    fun executeSomeComplexOperation(message: String, function: (String) -> Unit) {
        function("ModelInteractor $name received ${prepareMessage(message)}")
    }

    private fun prepareMessage(message: String): String {
        if (message.isEmpty()) {
            return "an empty message"
        } else {
            return message
        }
    }
}
