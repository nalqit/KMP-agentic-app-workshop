package ly.com.tahaben.agentic_workshop.kmp_agentic_app_workshop

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}