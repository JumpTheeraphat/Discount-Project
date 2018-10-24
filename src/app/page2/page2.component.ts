import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { PageService } from '../page.service';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { PARAMETERS } from '@angular/core/src/util/decorators';

@Component({
  selector: 'app-page2',
  templateUrl: './page2.component.html',
  styleUrls: ['./page2.component.css']
})
export class Page2Component implements OnInit {

  Buttontoggle:boolean = false;
  PromotionName: String;
  PromotionTitle: String;
  PromotionDuration: String;
  PromotionType: number;
  Startdate: null;
  Enddate: null;
  Code:String;

  constructor(private httpClient: HttpClient) { }

  ngOnInit() {
  }

  save(){
    if(this.PromotionName === undefined || this.PromotionTitle === undefined || this.PromotionType === undefined || this.Startdate === undefined || this.Enddate === undefined || this.PromotionDuration === undefined) {
    alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    }
    else{
        this.httpClient.post('http://localhost:8080/discount/create/' + this.PromotionName + '/' + this.PromotionTitle+ '/' + this.PromotionType,null).subscribe(
        data => {
            console.log('PUT Request is successful', data);
        },
        error => {
            console.log('**********Error***********', error);
            window.location.reload();
        }

  );

  this.httpClient.post('http://localhost:8080/period/create/'  + this.Startdate + '/' + this.Enddate+ '/' + this.PromotionDuration,null).subscribe(
        data => {
            console.log('PUT Date is successful', data);
        },
        error => {
            console.log('===========Error==========', error);
            window.location.reload();
        }

  );
  if(1){
    this.httpClient.post('http://localhost:8080/coupon/create/'  + this.Code,null).subscribe(
        data => {
            console.log('PUT Code is successful', data);
        },
        error => {
            console.log('------------Error----------', error);
            window.location.reload();
        }

  );
  }
  }
  }

}
