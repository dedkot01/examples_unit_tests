package third_module

import org.scalatest.flatspec.AnyFlatSpec
import org.scalamock.scalatest.MockFactory
import scala.collection.mutable.ListBuffer
import org.scalamock.matchers.Matchers

class ShopClientSpec extends AnyFlatSpec with MockFactory:

  trait ShopCLientFixture:
    val mockSenderRequest = mock[Utils]
    val shopClient = new ShopClient("http://test", mockSenderRequest)

  trait ItemsFixture:
      val item1 = new Item(name = "Apple", quantity = 2)
      val item2 = new Item(name = "Banana", quantity = 4)

  "A ShopCLient" should "doesn't create order with empty backet" in new ShopCLientFixture:
    (mockSenderRequest.sendRequestCreateOrder).expects(*, *).returning(false).never()

    assert(shopClient.getBacket.length == 0)
    assert(shopClient.createOrder == false)

  it should "create order with not empty backet" in new ShopCLientFixture with ItemsFixture:
    (mockSenderRequest.sendRequestCreateOrder).expects(*, *).returning(true).once()

    shopClient.addItem(item = item1)
    shopClient.addItem(item = item2)
    assert(shopClient.getBacket.length == 2)
    assert(shopClient.createOrder == true)
