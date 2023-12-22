import numpy as np
import matplotlib.pyplot as plt


def solve_linear_system(coeff_matrix, constants, num_chains, chain_length):
    system_size = coeff_matrix.shape[0]
    solution = np.zeros(system_size)

    for equation_index in range(system_size):
        for _ in range(num_chains):
            weight = 1
            state_prev = equation_index
            state_new = 0
            solution[equation_index] += constants[equation_index]

            for _ in range(chain_length):
                state_new = np.random.choice(system_size)
                weight *= system_size * coeff_matrix[state_prev][state_new]
                solution[equation_index] += weight * constants[state_new]
                state_prev = state_new

    return solution / num_chains


coeff_matrix = np.array([[1.1, -0.1, 0.2],
                         [0.1, 0.5, 0.3],
                         [-0.3, -0.1, 1.3]])
coeff_matrix = np.array([[1, 0, 0],
                         [0, 1, 0],
                         [0, 0, 1]]) - coeff_matrix
constants = np.array([-3, 1, 4])
actual_solution = [-3.07018, 1.14035, 2.45614]

num_chains_set = [10, 30, 60, 100]
chain_length_set = [10, 100, 300, 1000]

results = {}

for num_chains in num_chains_set:
    for chain_length in chain_length_set:
        solution = solve_linear_system(coeff_matrix, constants, num_chains, chain_length)
        print(f'Number of Chains: {num_chains}')
        print(f'Chain Length: {chain_length}')
        print(f'Computed Solution: {solution}')
        print(f'Actual Solution: {actual_solution}')
        print()
        error = np.linalg.norm(solution - actual_solution)
        results[(num_chains, chain_length)] = error

plt.figure(figsize=(14, 7))

for i, num_chains in enumerate(num_chains_set):
    errors = [results[(num_chains, cl)] for cl in chain_length_set]
    plt.plot(chain_length_set, errors, label=f'Num Chains: {num_chains}')

plt.xlabel('Chain Length')
plt.ylabel('Error')
plt.yscale('log')
plt.xscale('log')
plt.legend()
plt.grid(True, which="both", ls="--")
plt.show()
