package ly.com.tahaben.agentic_workshop.kmp_agentic_app_workshop

class JVMPlatform : Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
}

actual fun getPlatform(): Platform = JVMPlatform()