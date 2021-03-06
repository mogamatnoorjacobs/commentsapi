package repositories.users

import domain.users.UserStatus
import org.joda.time.DateTime
import org.scalatest.{GivenWhenThen, FeatureSpec}

import scala.concurrent.Await
import scala.concurrent.duration._

/**
 * Created by Rosie on 2016/11/18.
 */
class UserStatusRepoTest extends FeatureSpec with GivenWhenThen{
  feature("Create Status") {
    info("Add a Status")
    scenario("Add a Status") {
      Given("Given A siteId,userId,status,date")
      val siteId ="github"
      val userId="user1"
      val status = "on"
      val date = new DateTime(2016,11,27,6,0,2,0)

      Then("Add Status ")
      val titletext = UserStatus(siteId,userId,status,date)
      val statusRepo = UserStatusRepository
      statusRepo.save(titletext)
      Then("Display All ")
      val displayStatus = Await.result(UserStatusRepository.getStatusByUserId(userId), 2 minutes)
      displayStatus.foreach(i => println("Status=======>",i))
    }
  }


}
