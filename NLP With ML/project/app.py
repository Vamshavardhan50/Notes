import streamlit as st
import joblib
import re

# Load model and vectorizer
try:
    model = joblib.load("logistic_model.pkl")
    vectorizer = joblib.load("tfidf_vectorizer.pkl")
except Exception as e:
    st.error(f"Error loading model/vectorizer: {e}")
    st.stop()

# Basic Stop Words (manually defined)
STOP_WORDS = {
    "i", "me", "my", "we", "you", "your", "he", "she", "it", "they", "them",
    "is", "are", "was", "were", "be", "been", "have", "has", "do", "does",
    "a", "an", "the", "and", "but", "if", "or", "because", "as", "until", "of", "at", "by"
}

# Clean text (No NLTK)
def clean_text(text):
    text = text.lower()
    text = re.sub(r"[^\w\s]", "", text)  # remove punctuation
    text = re.sub(r"\d+", "", text)      # remove numbers
    text = re.sub(r"[^\x00-\x7F]+", "", text)  # remove emojis
    words = text.split()
    words = [w for w in words if w not in STOP_WORDS]
    return " ".join(words)

# UI
st.set_page_config(page_title="Emotion Detection", page_icon="💬")
st.title("💬 Emotion Detector")
st.write("Enter a sentence and I'll predict the emotion behind it!")

user_input = st.text_area("Type your sentence here")

if st.button("Predict Emotion"):
    if not user_input.strip():
        st.warning("Please enter some text.")
    else:
        try:
            cleaned = clean_text(user_input)
            vectorized = vectorizer.transform([cleaned])
            prediction = model.predict(vectorized)[0]
            proba = model.predict_proba(vectorized)[0]

            st.success(f"Predicted Emotion: **{prediction}**")
            st.write("### Confidence Scores:")
            for label, score in zip(model.classes_, proba):
                st.write(f"- **{label}**: `{score:.2%}`")
        except Exception as e:
            st.error(f"Error during prediction: {e}")
