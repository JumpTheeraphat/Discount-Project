import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class PageService {

constructor(private http: HttpClient) {
  }
  public API = '//localhost:8080';
  getAllRestaurant(): Observable<any> {
    return this.http.get('//localhost:8080/Restaurant');
  }
  getAllDiscount(): Observable<any> {
    return this.http.get('//localhost:8080/Discount');
  }
  ShowDiscountdetail(id): Observable<any>{
    return this.http.get('//localhost:8080/Discountbyid/' + id);
  }
  ShowTime(Pid): Observable<any>{
    return this.http.get('//localhost:8080/Timebyid/' + Pid);
  }

}
