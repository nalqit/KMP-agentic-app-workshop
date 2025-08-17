package ly.com.tahaben.agentic_workshop.kmp_agentic_app_workshop

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform