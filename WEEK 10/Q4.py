from functools import reduce

units = [8, 12, 15, 6, 11]

# a) Days consuming more than 10 units
high = list(filter(lambda x: x > 10, units))
print("Consumption above 10:", high)

# b) Calculate daily electricity cost
cost = list(map(lambda x: x * 6, units))
print("Daily costs:", cost)

# c) Calculate total consumption
total = reduce(lambda x, y: x + y, units)
print("Total consumption:", total)

# d) Pure function to calculate electricity bill
def bill(consumption):
    return consumption * 6

print("Total bill:", bill(total))
