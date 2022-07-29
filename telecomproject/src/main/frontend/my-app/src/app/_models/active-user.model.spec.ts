import { ActiveUser } from './active-user.model';

describe('ActiveUser', () => {
  it('should create an instance', () => {
    expect(new ActiveUser('','','','',[],[])).toBeTruthy();
  });
});
