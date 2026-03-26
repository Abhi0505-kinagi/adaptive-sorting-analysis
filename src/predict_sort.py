import sys
import joblib
import pandas as pd
from collections import defaultdict

features = ['n', 'sortedness', 'inversion_ratio', 'duplicate_ratio', 'entropy']

scaler = joblib.load("pairwise_scaler.pkl")
pairwise_models = joblib.load("pairwise_models.pkl")

def predict_new(sample_input):
    votes = defaultdict(int)
    x = pd.DataFrame([sample_input])
    x_scaled = scaler.transform(x)

    for (a1, a2), model in pairwise_models.items():
        pred = model.predict(x_scaled)[0]
        if pred == 1:
            votes[a1] += 1
        else:
            votes[a2] += 1

    return max(votes, key=votes.get)

if __name__ == "__main__":
    if len(sys.argv) != 6:
        print("ERROR")
        sys.exit(1)

    sample = {
        'n': float(sys.argv[1]),
        'sortedness': float(sys.argv[2]),
        'inversion_ratio': float(sys.argv[3]),
        'duplicate_ratio': float(sys.argv[4]),
        'entropy': float(sys.argv[5])
    }

    prediction = predict_new(sample)
    print(prediction)