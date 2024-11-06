package third_module

import scala.collection.mutable.ListBuffer


class ShopClient(hostAddr: String = "http://localhost:8080", utils: Utils):
  private val backet: ListBuffer[Item] = ListBuffer()

  def getBacket: List[Item] = backet.toList

  def addItem(item: Item): Unit = backet += item

  def removeItem(item: Item): Unit = backet -= item

  def clearBacket: Unit = backet.clear()

  def createOrder: Boolean =
    if (backet.isEmpty)
      return false

    val result = utils.sendRequestCreateOrder(hostAddr, backet)
    if (result)
      clearBacket

    result
