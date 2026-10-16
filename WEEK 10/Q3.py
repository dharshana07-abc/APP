# a) Pure function to calculate discounted price
def discount(price):
    if price > 1000:
        return price * 0.80
    return price

prices = [500, 1200, 2000, 800, 1500]

# b) Apply discount using map()
new_prices = list(map(discount, prices))
print("Discounted prices:", new_prices)

# c) Identify products costing more than 1000
eligible = list(filter(lambda p: p > 1000, prices))
print("Eligible products:", eligible)
