import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Course } from '../course';
import { CourseService } from '../course.service';

@Component({
  selector: 'app-view-course',
  templateUrl: './view-course.component.html',
  styleUrls: ['./view-course.component.css']
})
export class ViewCourseComponent implements OnInit {
  course = new Course();
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
  showDetail() {
    this.route.navigate(['./courselist'])
  }
}
