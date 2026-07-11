package com.monsoon.care.ui.activities;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.monsoon.care.R;

/**
 * AI Safety Assistant Activity - Natural language AI Assistant
 * Users can ask questions about preparedness, safety, travel safety
 */
public class AISafetyAssistantActivity extends AppCompatActivity {

    private EditText questionInput;
    private TextView responseText;
    private Button askButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai_assistant);

        questionInput = findViewById(R.id.question_input);
        responseText = findViewById(R.id.response_text);
        askButton = findViewById(R.id.btn_ask);

        askButton.setOnClickListener(v -> askAI());
    }

    private void askAI() {
        String question = questionInput.getText().toString().trim();
        if (!question.isEmpty()) {
            // Call AI API to get response
            responseText.setText("Processing your question...");
            // Placeholder - Will integrate with actual AI service
        }
    }
}

