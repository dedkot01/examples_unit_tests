package third_module

import sttp.client4.quick.*
import sttp.client4.Response
import scala.collection.mutable.ListBuffer


class Utils:
  def sendRequestCreateOrder(hostAddr: String, order: ListBuffer[Item]): Boolean =
    val json_body = order.map(_.toJson).mkString("[", ",", "]")
    val response: Response[String] = quickRequest
      .post(uri"$hostAddr/api/order")
      .body(json_body)
      .send()
    response.code.isSuccess
