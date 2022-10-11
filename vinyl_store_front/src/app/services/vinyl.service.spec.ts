import { TestBed } from '@angular/core/testing';

import { VinylService } from './vinyl.service';

describe('VinylService', () => {
  let service: VinylService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VinylService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
