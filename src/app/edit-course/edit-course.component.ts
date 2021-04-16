import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Course } from '../course';
import { CourseService } from '../course.service';

@Component({
  selector: 'app-edit-course',
  templateUrl: './edit-course.component.html',
  styleUrls: ['./edit-course.component.css']
})
export class EditCourseComponent implements OnInit {
  course = new Course();
  //autowiring ..dependency injection
  constructor(private courseService: CourseService, private route: Router, private activeRouter: ActivatedRoute) { }


  ngOnInit(): void {
    let id = parseInt(this.activeRouter.snapshot.params['id']);
    console.log(id)
    this.courseService.fetchCourseByIdFromRest(id).subscribe(
      data => {
        console.log("data recieved")
        this.course = data;
      },
      error => console.log("error occured")
    )
  }
  updateCourseFormsubmit() {
    console.log(this.course);
    this.courseService.addCourseToRemote(this.course).subscribe
      (

        _data => {
          console.log("data  addedd successfully");
          this.route.navigate(['courselist'])
        },
        error => console.log("error")
      )
  }
  goToCourseList() {
    console.log("going to course list")
    this.route.navigate(['courselist'])
  }
}
