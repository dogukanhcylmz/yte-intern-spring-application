package yte.intern.application.common.response;

public record MessageResponse(
        String message,
        MessageType messageType
) {
}