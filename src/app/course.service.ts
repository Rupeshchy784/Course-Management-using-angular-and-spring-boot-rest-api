import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Course } from './course';
@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor(private http: HttpClient) { }
  private baseUrl = "http://localhost:8080/api/";
  fetchCourseListFromRest(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}` + `courses`)

  }
  addCourseToRemote(course: Course): Observable<any> {
    return this.http.post<any>("http://localhost:8080/api/courses", course);

  }
  fetchCourseByIdFromRest(id: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}` + `courses/` + id)
  }
  deleteCourseByIdFromRest(id: number): Observable<any> {
    return this.http.delete<any>(`${this.baseUrl}` + `course/` + id)
  }
}
