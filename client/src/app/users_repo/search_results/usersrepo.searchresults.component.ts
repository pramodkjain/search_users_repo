import {Http, Headers} from '@angular/http';
import {Component, Input} from "@angular/core";
import {CommonService} from "../../common/common.service";
import {SearchResultInput} from "../usersrepo.searchresults.input";

@Component({
  selector: 'usersrepo-searchresults',
  templateUrl: './usersrepo.searchresults.html'
})
export class UsersRepoSearchResultsComponent {

  @Input() searchResultInput : SearchResultInput;

  constructor(public http: Http, private commonService: CommonService) {
  }



}
