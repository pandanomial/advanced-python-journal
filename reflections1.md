### I want to use double rather than float

### prompt: create decimal class equivalent to c++ double 

from decimal import Decimal, Context

class Double:
  def __init__(self, value):
    self.value = Decimal(str(value), Context(prec=15))

  def __add__(self, other):
    if isinstance(other, Double):
      return Double(self.value + other.value)
    else:
      return Double(self.value + Decimal(str(other)))

  def __sub__(self, other):
    if isinstance(other, Double):
      return Double(self.value - other.value)
    else:
      return Double(self.value - Decimal(str(other)))

  def __mul__(self, other):
    if isinstance(other, Double):
      return Double(self.value * other.value)
    else:
      return Double(self.value * Decimal(str(other)))

  def __truediv__(self, other):
    if isinstance(other, Double):
      return Double(self.value / other.value)
    else:
      return Double(self.value / Decimal(str(other)))

  def __str__(self):
    return str(self.value)

  def __repr__(self):
    return f"Double({self.value})"

  print(Double(1) / Double(7))
