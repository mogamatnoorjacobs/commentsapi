package services.comments

import com.datastax.driver.core.ResultSet
import domain.comments.Subject
import services.Service
import services.comments.Impl.SubjectServiceImpl

import scala.concurrent.Future

/**
  * Created by Bonga on 11/13/2016.
  */
trait SubjectService {

  def getSubjectBySubjectId(id:String): Future[Option[Subject]]
  def save(subject: Subject):Future[ResultSet]
  def getAllSubject: Future[Seq[Subject]]
  def deleteAll:Future[ResultSet]

}

object SubjectService extends Service {
  def apply(): SubjectService = new SubjectServiceImpl
}