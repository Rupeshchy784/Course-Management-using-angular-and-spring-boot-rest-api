import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CourseListComponent } from './course-list/course-list.component';
import { AddCourseComponent } from './add-course/add-course.component'
import { ViewCourseComponent } from './view-course/view-course.component';
import { EditCourseComponent } from './edit-course/edit-course.component';

const routes: Routes = [

  { path: '', component: CourseListComponent },
  { path: 'courselist', component: CourseListComponent },
  { path: 'updatedcourselist', component: CourseListComponent },
  { path: 'addcourse', component: AddCourseComponent },
  { path: 'viewcourse', component: ViewCourseComponent },
  { path: 'editcourse', component: EditCourseComponent },
  { path: 'editcourse/:id', component: EditCourseComponent },
  { path: 'viewcourse/:id', component: ViewCourseComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
