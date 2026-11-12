package com.guiaia.app;

/** TEXTOS DE LA GUÍA. Reemplaza las descripciones por las del PDF cuando lo tengas. */
public class Contenido {
    static final String TITULO = "GUÍA DE INTELIGENCIA ARTIFICIAL";
    static final String SUBTITULO = "Las IA's más importantes en cada categoría para que elijas mejor cada vez y seas más eficiente.";

    static final String[] CATEGORIAS = {
        "Todas", "Chatbots", "Programación y desarrollo", "Creación de imágenes"
    };

    // {categoría, nombre, descripción, enlace}
    static final String[][] HERRAMIENTAS = {
        {"Chatbots", "ChatGPT", "Asistente conversacional de OpenAI para escribir, resumir, analizar y resolver dudas.", "https://chatgpt.com"},
        {"Chatbots", "Gemini", "La IA de Google, integrada con su buscador y sus aplicaciones.", "https://gemini.google.com"},
        {"Chatbots", "Microsoft Copilot", "Asistente de Microsoft para el día a día y las herramientas de Office.", "https://copilot.microsoft.com"},
        {"Chatbots", "DeepSeek", "Modelo de lenguaje con buen razonamiento y gran relación costo-beneficio.", "https://chat.deepseek.com"},
        {"Chatbots", "Perplexity", "Buscador con IA que responde con fuentes citadas.", "https://www.perplexity.ai"},
        {"Chatbots", "Meta AI", "Asistente de Meta disponible dentro de WhatsApp, Instagram y Facebook.", "https://www.meta.ai"},
        {"Programación y desarrollo", "GitHub Copilot", "Asistente que sugiere y completa código directamente en tu editor.", "https://github.com/features/copilot"},
        {"Creación de imágenes", "Midjourney", "Generador de imágenes artísticas de alta calidad a partir de texto.", "https://www.midjourney.com"},
        {"Creación de imágenes", "Stable Diffusion", "Modelo de imágenes abierto y personalizable.", "https://stability.ai"},
        {"Creación de imágenes", "Krea", "Creación y mejora de imágenes con IA en tiempo real.", "https://www.krea.ai"},
    };
}
