import matplotlib.pyplot as plt

with open('correlations.txt', 'r') as f:
    correlations = [float(line.strip()) for line in f]

plt.hist(correlations, bins=10)
plt.xlabel('Value')
plt.ylabel('Frequency')
plt.title('Histogram of Output Data')
plt.show()
