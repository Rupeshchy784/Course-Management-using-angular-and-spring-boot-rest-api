import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Course } from '../course';
import { CourseService } from "../course.service"
@Component({
  selector: 'app-add-course',
  templateUrl: './add-course.component.html',
  styleUrls: ['./add-course.component.css']
})
export class AddCourseComponent implements OnInit {
  course = new Course();
  constructor(private courseService: CourseService, private route: Router) { }

  ngOnInit(): void {
  }
  addcourseformsubmit() {
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
    console.log("coming")
    this.route.navigate(['courselist'])
  }
}
