package nsus.payment.multimoduleproj

import User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {
  @GetMapping("/user")
  fun getUser(): User {
    return User(
      1,
      "Sean.Lim",
      "sean@gmail.com"
    )
  }
}
