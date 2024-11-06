package third_module


case class Item(name: String, quantity: Int):

  require(quantity > 0)

  def toJson: String =
    s"""{"name": "${name}", "quantity": ${quantity}}"""
