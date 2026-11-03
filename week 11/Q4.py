import sympy as sp
t = sp.Symbol('t')
s = t**3 - 6*t**2 + 9*t + 5
v = sp.diff(s, t)
print("Velocity:", v)
a = sp.diff(v, t)
print("Acceleration:", a)
rest_time = sp.solve(v, t)
print("Vehicle at rest at:", rest_time)
distance = sp.integrate(s, (t, 0, 3))
print("Displacement integral from 0 to 3:", distance)
