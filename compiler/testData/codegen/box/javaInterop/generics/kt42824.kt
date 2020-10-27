// FILE: DiagnosticFactory0.java

import org.jetbrains.annotations.NotNull;

public class DiagnosticFactory0<E> {
    @NotNull
    public SimpleDiagnostic<E> on(@NotNull E element) {
        return new SimpleDiagnostic<>(element);
    }
}

// FILE: test.kt
// IGNORE_BACKEND: JS
// IGNORE_BACKEND: JS_IR

class SimpleDiagnostic<E>(val element: E)
interface KtAnnotationEntry

fun foo(error: DiagnosticFactory0<in KtAnnotationEntry>, entry: KtAnnotationEntry) {
    error.on(entry) // used to be INAPPLICABLE_CANDIDATE
}

fun box() = "OK"