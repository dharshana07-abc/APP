import sympy as sp
x = sp.Symbol('x')
expr = (x + 2) * (x + 3)
expanded = sp.expand(expr)
print("Expanded Expression:", expanded)
factorized = sp.factor(expanded)
print("Factorized Expression:", factorized)
expression = (x**2 + 2*x + 1) / (x + 1)
simplified = sp.simplify(expression)
print("Simplified Expression:", simplified)
equation = x**2 - 5*x + 6
solution = sp.solve(equation, x)
print("Quadratic Equation:", equation)
print("Solutions:", solution)
