
# Math modeling

Math modeling labs overview

## Generalized Multiplicative Method (Lab 1)

This project implements two classes of random number generators: Multiplicative Congruential Generator (MCG) and Generalized Multiplicative Method (GMM). It also provides some methods to test and compare the performance of these generators.

### Classes

- `Generator<T>`: An interface that defines a generic random number generator with two methods: `get()` and `reset()`.
- `MultiplicativeCongruentialGenerator<T>`: A class that implements the `Generator<T>` interface and represents a MCG with the formula $$x_{n+1} = ax_n \mod m$$, where $a$ is the multiplier, $m$ is the modulus, and $x_0$ is the initial seed.
- `GeneralizedMultiplicativeMethod<T>`: A class that implements the `Generator<T>` interface and represents a GMM with the formula $$x_{n+1} = x_{n-k}x_n \mod m$$, where $k$ is the lag, $m$ is the modulus, and $x_0, x_1, \dots, x_k$ are the initial seeds. This class uses two MCGs as the primary and secondary generators to fill the initial value table.

### Methods

- A static method that returns a random number generated by the given generator after the specified number of iterations:
	```java
	RandomNumberOperations.generateNumber(Generator<T> numberGenerator, long requiredIterations);
	```
- A static method that creates a MCG with the given parameters and prints the first, fifteenth, and thousandth numbers generated by it:
	```java
	RandomNumberOperations.partA(long seed, long constant, long modulo);
	```
- A static method that creates two MCGs with the given parameters and a GMM with the given size using the MCGs as the primary and secondary generators. It prints the first, second, and thousandth numbers generated by the GMM:
	```java
	RandomNumberOperations.partB(long seed1, long constant1, long modulo1, long seed2, long constant2, long modulo2, int size);
	```
- A static method that creates a MCG with the given parameters and prints the first and $(m+1)$-th numbers generated by it, where $m$ is the modulus
	```java
	RandomNumberOperations.additionalOperation7(long seed, long constant, long modulo);
	```
- A static method that creates two MCGs with the given parameters and a GMM with the given size using the MCGs as the primary and secondary generators. It prints the first and $(m+1)$-th numbers generated by the GMM, where $m$ is the modulus of the primary generator:
	```java
	RandomNumberOperations.additionalOperation8(long seed1, long constant1, long modulo1, long seed2, long constant2, long modulo2, int size);
	```

## Discrete Probability Distributions (Lab 2)

This project implements four classes of discrete random variables: Binomial, Bernoulli, Geometric, and Poisson. It also provides some methods to test and compare the expected value and variance of these variables.

### Classes

- `DiscreteGenerator`: An interface that defines a generic discrete random variable with one method: `get()`.
- `BinomialDistribution`: A class that implements the `DiscreteGenerator` interface and represents a binomial random variable with the probability mass function $$P(X = k) = \binom{n}{k}p^k(1-p)^{n-k}$$, where $n$ is the number of trials, $p$ is the probability of success, and $k$ is the number of successes.
- `BernoulliDistribution`: A class that extends the `BinomialDistribution` class and represents a Bernoulli random variable with the probability mass function $$P(X = k) = p^k(1-p)^{1-k}$$, where $p$ is the probability of success, and $k$ is either 0 or 1.
- `GeometricDistribution`: A class that implements the `DiscreteGenerator` interface and represents a geometric random variable with the probability mass function $$P(X = k) = p(1-p)^{k-1}$$, where $p$ is the probability of success, and $k$ is the number of trials until the first success.
- `PoissonDistribution`: A class that implements the `DiscreteGenerator` interface and represents a Poisson random variable with the probability mass function $$P(X = k) = \frac{\lambda^k e^{-\lambda}}{k!}$$, where $\lambda$ is the mean, and $k$ is a non-negative integer.

### Methods

- A static method that prints the name of the test, the expected value and variance of the random variable, and the results of 10 trials using the given generator
	```java
	RandomDiscrete.test(String name, DiscreteGenerator generator, double expectedValue, double variance);
	```
- A static method that creates a binomial random variable with some sample parameters and calls the `RandomDiscrete.test` method with it:
	```java
	RandomDiscrete.testBinomial();
	```
- A static method that creates a Bernoulli random variable with some sample parameters and calls the `RandomDiscrete.test` method with it:
	```java
	RandomDiscrete.testBernoulli();
	```
- A static method that creates a geometric random variable with some sample parameters and calls the `RandomDiscrete.test` method with it:
	```java
	RandomDiscrete.testGeometric();
	```
- `RandomDiscrete.testPoisson()`: A static method that creates a Poisson random variable with some sample parameters and calls the `RandomDiscrete.test` method with it:
	```java
	RandomDiscrete.testGeometric();
	```


## Probability Distribution Generators (Lab 3)

This project implements five classes of continuous random variables: Normal, Log-Normal, Exponential, Logistic, and Laplacian. It also provides some methods to test and compare the expected value and variance of these variables.

### Classes

- `Generator<T>`: An interface that defines a generic continuous random variable with one method: `get()`.
- `NormalGenerator<T>`: A class that implements the `Generator<T>` interface and represents a normal random variable with the probability density function $$f(x) = \frac{1}{\sqrt{2\pi\sigma^2}}e^{-\frac{(x-\mu)^2}{2\sigma^2}}$$, where $\mu$ is the expectation, $\sigma^2$ is the variance, and $x$ is the value.
- `LogNormalGenerator<T>`: A class that extends the `NormalGenerator<T>` class and represents a log-normal random variable with the probability density function $$f(x) = \frac{1}{x\sqrt{2\pi\sigma^2}}e^{-\frac{(\ln x - \mu)^2}{2\sigma^2}}$$, where $\mu$ and $\sigma^2$ are the parameters of the underlying normal distribution, and $x$ is the value.
- `ExponentialGenerator<T>`: A class that implements the `Generator<T>` interface and represents an exponential random variable with the probability density function $$f(x) = \lambda e^{-\lambda x}$$, where $\lambda$ is the rate parameter, and $x$ is the value.
- `LogisticGenerator<T>`: A class that implements the `Generator<T>` interface and represents a logistic random variable with the probability density function $$f(x) = \frac{e^{-(x-a)/b}}{b(1+e^{-(x-a)/b})^2}$$, where $a$ is the location parameter, $b$ is the scale parameter, and $x$ is the value.
- `LaplacianGenerator<T>`: A class that implements the `Generator<T>` interface and represents a Laplacian random variable with the probability density function $$f(x) = \frac{\lambda}{2}e^{-\lambda|x-\mu|}$$, where $\mu$ is the location parameter, $\lambda$ is the scale parameter, and $x$ is the value.

### Methods

- A static method that prints the name of the test, the expected value and variance of the random variable, and the results of 10 trials using the given generator:
	```java
	Main.test(String name, Generator<T> generator, double expectedValue, double variance);
	```
- A static method that creates a normal random variable with some sample parameters and calls the `Main.test` method with it:
	```java
	Main.testNormal();
	``` 
- A static method that creates a log-normal random variable with some sample parameters and calls the `Main.test` method with it:
	```java
	Main.testLogNormal();
	``` 
- A static method that creates an exponential random variable with some sample parameters and calls the `Main.test` method with it:
	```java
	Main.testExponential();
	```
- A static method that creates a logistic random variable with some sample parameters and calls the `Main.test` method with it:
	```java
	Main.testLogistic();
	```
- A static method that creates a Laplacian random variable with some sample parameters and calls the `Main.test` method with it:
	```java
	Main.testLaplacian();
	```

## Numerical Integration Approximations (Lab 4)

This Java program approximates definite integrals using Monte Carlo methods.

### Description

This project implements two methods of numerical integration: Monte Carlo method and Simpson's rule. It also provides some methods to calculate and compare the actual and approximate values of some integrals.

### Prerequisites

Make sure you have Java installed on your system.

### Usage

1. Compile the Java file `Main.java`:
	```bash
	javac Main.java
	```
2. Run the compiled program:
	```bash
	java Main
	```

### Methods

- A static method that prints the prompt, the actual answer, and the approximate answer of an integral to the standard output.
	```java
	Main.print(String prompt, double actualAnswer, double approximateAnswer);
	```
- `Main.integral1()`: A static method that calculates the integral $$\int_0^{\frac{5\pi}{7}} \cos(x + \sin(x)) dx$$
using the Monte Carlo method with 10000 iterations. It calls the `print` method with the result and the actual answer of -0.485736.
- `Main.integral2()`: A static method that calculates the integral $$\iint_{1 \leq x^2 + y^2 \leq 3}\frac{dxdy}{x^2 + y^4}$$ using the Monte Carlo method with 10000 iterations. It calls the `print` method with the result and the actual answer of 3.21825.

### Notes

- Adjust the `NUM_ITERATIONS` constant in the `Main` class to change the precision of the approximation.
- The accuracy of the approximation increases with a larger number of iterations.

### Sample Output

```
cox(x + sin(x))dx from 0 to 5pi/7 = -0.485736, approximate = [approximateAnswer1]
dxdy / (x^2 + y^4) where 1 <= x^2 + y^2 <= 3 = 3.21825, approximate = [approximateAnswer2]
```

The actual values of the integrals are specified along with their respective approximations based on the Monte Carlo method.

## Linear System Solver using Markov Chain Monte Carlo (Lab 5)

This Python script solves a linear system of equations using a Markov Chain Monte Carlo (MCMC) method. It iterates through chains and lengths to approximate the solution. 

### Prerequisites

Make sure you have Python 3 installed. You'll also need `numpy` and `matplotlib` libraries.

### Installation

1. Clone the repository.
2. Install the required libraries using pip:
    ```bash
    pip install numpy matplotlib
    ```

### Usage

Run the Python script `main.py`:

```bash
main.py
```

### Details

The `solve_linear_system` function uses a Markov Chain Monte Carlo approach to approximate the solution of a given linear system. 

- `coeff_matrix`: Coefficient matrix of the linear system.
- `constants`: Constants in the linear equations.
- `num_chains`: Number of chains for the MCMC.
- `chain_length`: Length of each chain.

Adjust the `coeff_matrix`, `constants`, `num_chains_set`, and `chain_length_set` variables in the script to test different scenarios.

### Example

Here's an example of usage:

```python
coeff_matrix = np.array([[1, 0, 0],
                         [0, 1, 0],
                         [0, 0, 1]])
constants = np.array([-3, 1, 4])

num_chains_set = [10, 30, 60, 100]
chain_length_set = [10, 100, 300, 1000]

# Run the solver
# (Add the code for running the solver here)
```

### Output

The script generates a plot showing the error in the computed solutions compared to the actual solutions for different numbers of chains and chain lengths.
