import React, { useState } from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import { useNavigate } from 'react-router-dom';

import searchButton from '../img/search_button.png';
import './Search.css';

function Search() {
  const [text, setText] = useState('');
  const navigate = useNavigate();
  const [isSearchBarOn, setIsSearchBarOn] = useState(false);
  const onChange = (e) => {
    setText(() => e.target.value);
  };

  const onSubmit = () => {
    navigate('/search', { state: { value: text } });
  };

  const handleOnKeyPress = (e) => {
    if (e.key === 'Enter') {
      onSubmit();
    }
  };

  const onClick = () => {
    if (text !== '') onSubmit();
    setText('');
    setIsSearchBarOn(() => !isSearchBarOn);
  };

  return (
    <div className={['search', isSearchBarOn && 'search--active'].join(' ')}>
      {isSearchBarOn && (
        <input
          className="search-input"
          onChange={onChange}
          value={text}
          onKeyDown={handleOnKeyPress}
        />
      )}
      <button className="search-button" type="submit" onClick={onClick}>
        <img
          className="search-button-img"
          alt="search-button"
          src={searchButton}
        />
      </button>
    </div>
  );
}

export default Search;
