import React from 'react';
import { Link } from 'react-router-dom';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';

import '../css/SettingBox.css';

const SettingBox = function ({ id }) {
  return (
    <div className="setting-box">
      <Link to={`/admin/user/${id}`}>
        <button type="button" className="setting-box-edit__button">
          수정하기
        </button>
      </Link>
      <button type="button" className="setting-box-resign__button">
        탈퇴시키기
      </button>
    </div>
  );
};

SettingBox.propTypes = {
  id: PropTypes.number.isRequired,
};

export default SettingBox;
