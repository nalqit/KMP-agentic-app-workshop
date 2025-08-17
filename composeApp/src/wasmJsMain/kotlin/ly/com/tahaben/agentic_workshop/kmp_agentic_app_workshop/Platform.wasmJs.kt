package ly.com.tahaben.agentic_workshop.kmp_agentic_app_workshop

class WasmPlatform : Platform {
    override val name: String = "Web with Kotlin/Wasm"
}

actual fun getPlatform(): Platform = WasmPlatform()