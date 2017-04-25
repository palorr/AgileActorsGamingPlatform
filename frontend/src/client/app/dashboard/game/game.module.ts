import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { GameComponent } from './game.component';

import {GameProfileComponent} from './gameProfile.component';
import {GameListComponent} from './gameList.component';

import { TruncateModule }   from '../../pipes/truncate.module';

import {
  TabsModule,
  ModalModule
} from 'ng2-bootstrap/ng2-bootstrap';
import {GameSearchComponent} from './gameSearch.component';


@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    TabsModule,
    ModalModule,
    TruncateModule
  ],
  declarations: [
    GameComponent,
    GameProfileComponent,
    GameListComponent,
    GameSearchComponent
  ],
  exports: [
    GameComponent,
    GameProfileComponent,
    GameListComponent,
    GameSearchComponent
  ]
})

export class GameModule { }
