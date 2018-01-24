import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import {AppComponent} from './app.component';
import {CommonService} from "./common/common.service";
import {NgxTypeaheadModule} from "ngx-typeahead";
import {UsersRepoInputFormComponent} from "./users_repo/input_form/usersrepo.inputform.component";
import {UsersRepoSearchResultsComponent} from "./users_repo/search_results/usersrepo.searchresults.component";

@NgModule({
  declarations: [
    AppComponent,
    UsersRepoInputFormComponent,
    UsersRepoSearchResultsComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    NgxTypeaheadModule
  ],
  providers: [CommonService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
