import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CourseService } from "../course.service"
@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css']
})
export class CourseListComponent implements OnInit {

  constructor(private courseService: CourseService, private route: Router) { }
  course: any[] = [];
  ngOnInit(): void {
    this.courseService.fetchCourseListFromRest().subscribe(
      data => this.course = data,
      _error => console.log("error recieved")
    )
  }
  goToAddCourse() {
    console.log("going to add course component")
    this.route.navigate(['./addcourse']);
  }
  goToEditCourse(id: any) {
    console.log("open editcomponent" + id);
    this.route.navigate(['./editcourse', id]);
  }
  goToViewCourse(id: any) {
    this.route.navigate(['./viewcourse', id])
  }
  deleteCourse(id: any) {
    this.courseService.deleteCourseByIdFromRest(id).subscribe(
      data => {
        console.log("course deleted");
        this.route.navigate(['./updatedcourselist'])
      },
      error => console.log("can't deleted")
    )
  }
}
