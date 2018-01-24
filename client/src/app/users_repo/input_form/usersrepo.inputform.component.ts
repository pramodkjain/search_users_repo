import {Http, Headers} from '@angular/http';
import {Component} from "@angular/core";
import {InputForm} from "./usersrepo.inputform";
import {CommonService} from "../../common/common.service";
import {SearchResultInput} from "../usersrepo.searchresults.input";

@Component({
  selector: 'usersrepo-input-form',
  templateUrl: './usersrepo.inputform.html'
})
export class UsersRepoInputFormComponent {

  public model = new InputForm('');

  public searchResultInput = new SearchResultInput(null);

  constructor(public http: Http, private commonService: CommonService) {
  }

  public submit() {
    this.commonService.clearErrMsg();
    console.log(JSON.stringify(this.model));
    let headers = new Headers({'Content-Type': 'application/json'});
    var userId = this.model.userId;
    var getAllReposAPTUrl = '/api/github/users/' + userId + '/repos'
    this.http
      .get(getAllReposAPTUrl, {headers: headers})
      .subscribe(
        response => {
          this.searchResultInput.repositoryArray = response.json();
          console.log(response.json())
          this.prepareMessageIfSearchedMoreThanTwice(userId);
        },
        error => this.commonService.handleError(error),
        () => console.log('Rest API call complete!')
      );
  }

  private prepareMessageIfSearchedMoreThanTwice(userId: String) {
    let headers = new Headers({'Content-Type': 'application/json'});
    var searchedUserCountUrl = '/api/github/users/' + userId + '/searchedCount'
    var searchedCountInLastThreeMinutes = 0;
    this.http
      .get(searchedUserCountUrl, {headers: headers})
      .subscribe(
        response => {
          searchedCountInLastThreeMinutes = response.json();
          console.log(response.json())
          if (searchedCountInLastThreeMinutes >= 2) {
            this.commonService.setMessage("A previous user has searched this repo before!");
          }
        },
        error => this.commonService.handleError(error),
        () => console.log('Rest API call complete!')
      );
  }

}
