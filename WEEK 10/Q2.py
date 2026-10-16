from functools import reduce

salaries = [30000, 45000, 35000, 50000, 25000]

# a) Revise salaries
revised = list(map(
    lambda s: s * 1.10 if s < 40000 else s,
    salaries
))
print("Revised salaries:", revised)

# b) Identify eligible employees
eligible = list(filter(lambda s: s < 40000, salaries))
print("Eligible salaries:", eligible)

# c) Total salary expenditure after revision
total = reduce(lambda x, y: x + y, revised)
print("Total expenditure:", total)
