import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FeatureRequestData } from 'src/modal/feature-request-modal';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  featureReqeusts : FeatureRequestData[] = [];
  featureRequestData : FeatureRequestData = new FeatureRequestData();
  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get<FeatureRequestData[]>('api/v1/featurerequests').subscribe(data => {
            this.featureReqeusts = data;
    });
  }

  onSubmit(){
    this.http.post<any>('api/v1/featurerequest', this.featureRequestData).subscribe(data => {
      this.featureReqeusts = data;
      this.featureRequestData = new FeatureRequestData();
    });
    
  }
}
