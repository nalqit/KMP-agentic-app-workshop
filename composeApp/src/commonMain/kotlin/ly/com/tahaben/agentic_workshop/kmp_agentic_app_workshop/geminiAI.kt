package ly.com.tahaben.agentic_workshop.kmp_agentic_app_workshop

import dev.shreyaspatil.ai.client.generativeai.GenerativeModel
import dev.shreyaspatil.ai.client.generativeai.type.GenerateContentResponse
import kmp_agentic_app_workshop.composeapp.generated.resources.Res
import kotlinx.coroutines.flow.Flow

class geminiAI {

    val generativeModel = GenerativeModel(
        modelName = "gemini-2.5-flash",
        "<apikey>"
    )

    fun generateContent(prompt: String): Flow<GenerateContentResponse> {
        return generativeModel.generateContentStream(prompt)
    }


}
