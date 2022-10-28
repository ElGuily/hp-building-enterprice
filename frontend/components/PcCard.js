import React from 'react'

import styles from '../styles/PcCard.module.css'

function PcCard(props) {
    return (
        <article className={styles.pcCard}>
            <img src={props.img} alt="img" className={styles.pcCard__img} />
            <div className={styles.pcCard__div}>
                <h4 className={styles.pcCard__title}>{props.name}</h4>
                <span className={styles.pcCard__description}>{props.description}</span>
                <span className={styles.pcCard_precio}>{props.precio}$</span>
            </div>
        </article>
    )
}

export default PcCard